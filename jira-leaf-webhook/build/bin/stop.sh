#!/bin/bash
#2019年4月29日15:52:33
#bu auto stop_start_restart
export SERVICE_DIR="$(cd "$(dirname ${BASH_SOURCE[0]})/../" ; pwd -P)"
nohup ${SERVICE_DIR}/bin/service.sh stop > /dev/null 2>&1 &
exit 0

