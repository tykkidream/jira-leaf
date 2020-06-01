#!/bin/bash
#2019年4月29日15:52:33
#bu auto stop_start_restart
#by auther renxioakai

#########################################################################################
#  服务基本检查
#########################################################################################

checkUser() {
		if [ -z $user ]; then
				export user="deployer"
		fi

		if [ "`whoami`" = "$user" ]; then
				echo ""
		elif [ `cat /etc/passwd | cut -f1 -d ":" | grep -w $user -c` -eq  '1' ]; then
				echo $user
		else
				echo ""
		fi
}

arg(){
		# 默认不开启Debug
		ARGS_DEBUG="false"
		# 默认不开启JMX
		ARGS_JMS="false"
		ARGS_DEBUG_PORT=8000
		ARGS_JMX_HOST=192.168.3.167
		ARGS_JMX_PORT=5000

		ARGS=`getopt -o d::j: --long jmx_port:,jmx_host:,debug:: -n "$0" -- "$@"`

		if [ $? != 0 ]; then
				echo "Terminating..."
				exit 1
		fi
		eval set -- "${ARGS}"

		while true
		do
				case "$1" in
						-j|--jmx_port) 
								_OLD_IFS="$IFS"
								IFS=“:”
								_arr=($2)
								IFS="$_OLD_IFS"
								ARGS_JMX="true"
								ARGS_JMX_HOST=${_arr[0]}
								ARGS_JMX_PORT=${_arr[1]}
								shift 2 
								;;
						--jmx_port) 
								ARGS_JMX="true"
								ARGS_JMX_PORT=$2
								shift 2
								;;
						--jmx_host) 
								ARGS_JMX="true"
								ARGS_JMX_HOST=$2
								shift 2
								;;
						-d|--debug)
								ARGS_DEBUG="true"

								case "$2" in
										"")
												ARGS_DEBUG_PORT=8000
												shift 2  
												;;
										"--")
												ARGS_DEBUG_PORT=8000
												break  
												;;
										*)
												ARGS_DEBUG_PORT=$2
												shift 2;
												;;
								esac

								;;
						--)
								shift
								break
								;;
						*)
				  
								echo "Internal error!"
								#exit 1
								break
								;;
				esac
		done

		if [ "$ARGS_JMX" == "true" ]; then
				JAVA_OPTS_JMX="-Dcom.sun.management.jmxremote=true -Dcom.sun.management.jmxremote.port=$ARGS_JMX_PORT -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Djava.rmi.server.hostname=$ARGS_JMX_HOST"
		fi

		if [ "$ARGS_DEBUG" == "true" ]; then
				JAVA_OPTS_DEBUG="-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=$ARGS_DEBUG_PORT"
		fi
}



pre(){
		SERVICE_DIR=`dirname "${BASH_SOURCE-$0}"`
		SERVICE_DIR=`cd "$SERVICE_DIR/..">/dev/null; pwd`
		SERVICE_DIR_CONFIG=$SERVICE_DIR"/config"
		SERVICE_DIR_LIB=$SERVICE_DIR"/lib"

		source $SERVICE_DIR/bin/env.sh

		if [ -z $SERVICE_MAIN_CLASS ]; then
				echo -e "\033[40;31m 查检异常：SERVICE_MAIN_CALSS 未指定！ \033[0m"
				exit 1
		fi

		if [ ! -d "$SERVICE_DIR_CONFIG" ]; then
				echo -e "\033[40;31m 查检异常：$SERVICE_DIR_CONFIG 目录不存在！ \033[0m"
				exit 1
		fi

		if [ ! -d "$SERVICE_DIR_LIB" ]; then
				echo -e "\033[40;31m 查检异常：$SERVICE_DIR_LIB 目录不存在！ \033[0m"
				exit 1
		fi

		SERVICE_DIR_LIB_JARS=`ls $SERVICE_DIR_LIB|grep .jar|awk '{print "'$SERVICE_DIR_LIB'/"$0}'|tr "\n" ":"`
		SERVICE_PORT=`grep  "dubbo.protocol.port" $SERVICE_DIR_CONFIG"/application.properties" |sed 's/dubbo.protocol.port=//g'|sed 's/\r//g'`
		SERVICE_PID=$(netstat -nlp | grep :$SERVICE_PORT| awk '{print $7}' | awk -F"/" '{ print $1 }')
}


#########################################################################################
#  服务命令任务
#########################################################################################

doKill(){
		if [ ! -n "$SERVICE_PID" ]; then
                echo -e "\033[32m没有任何服务进程在运行中\033[0m"
				return 0
		fi
		
		_USER=`checkUser`

		if [ "$_USER" != "" ]; then
				su $_USER -c "kill -9 $SERVICE_PID"
		else
				kill -9 $SERVICE_PID
		fi

		_SUCCESS=`ps -ef | grep $SERVICE_PID`
		
		if [ -n _SUCCESS ]; then
				echo -e "\033[32m杀死服务 $SERVICE_PID 成功！\033[0m"
				unset SERVICE_PID
				return 0
		else
				echo -e "\033[32m杀死服务 $SERVICE_PID 失败！\033[0m"
				return 1
		fi
}

doRun(){
		if [ -n "$SERVICE_PID" ];then
				echo -e "\033[32m服务 $SERVICE_PID 已经在运行中！\033[0m"
				return 1
		fi

		# 启动参数解析
		arg $*

		echo "服务：$SERVICE_DIR"

		if [ -n "$JAVA_OPTS_JMX" ]; then
				echo "监控：$JAVA_OPTS_JMX"
		fi

		if [ -n "$JAVA_OPTS_DEBUG" ]; then
				echo "调试：$JAVA_OPTS_DEBUG"
		fi
        
		echo "命令：java $JAVA_OPTS $JAVA_OPTS_JMX $JAVA_OPTS_DEBUG -classpath $SERVICE_DIR_CONFIG:$SERVICE_DIR_LIB_JARS:$CLASSPATH $SERVICE_MAIN_CLASS"
		echo
		echo
		echo 开始...
		echo
		echo
		
		_USER=`checkUser`

		if [ "$_USER" != "" ]; then
				su $_USER -c "java $JAVA_OPTS $JAVA_OPTS_JMX $JAVA_OPTS_DEBUG -classpath $SERVICE_DIR_CONFIG:$SERVICE_DIR_LIB_JARS:$CLASSPATH $SERVICE_MAIN_CLASS"
		else
				java $JAVA_OPTS $JAVA_OPTS_JMX $JAVA_OPTS_DEBUG -classpath $SERVICE_DIR_CONFIG:$SERVICE_DIR_LIB_JARS:$CLASSPATH $SERVICE_MAIN_CLASS
		fi
}

#===========================================================================
#
# 脚本主体：开始执行！
#
#     启动 JAVA SE 程序！比如 Dubbo 项目，Spring Boot 项目。
#
#===========================================================================

COMMAND=$1

if [ $# -eq 0 ];then
		echo -e "\033[32m请指定命令： start 、 stop 、 restart 033[0m"
		exit 1
fi

shift

# 公共的预解析
pre

if [ $COMMAND == "start" ];then
		doRun $*
elif [ $COMMAND == "stop" ];then
		doKill
elif [ $COMMAND == "restart" ];then
		doKill
		if [ $? -eq 0 ]; then
				doRun $*
		fi
else
		echo -e "\033[32m未知命令！请使用 start 、 stop 、 restart 033[0m"
fi
