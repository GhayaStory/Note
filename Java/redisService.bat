@ echo off
%1 %2
ver|find "5.">nul&&goto :Admin
mshta vbscript:createobject("shell.application").shellexecute("%~s0","goto :Admin","","runas",1)(window.close)&goto :eof
:Admin

rem 以下是开启服务

for /f "skip=3 tokens=4" %%i in ('sc query "Redis" ') do set "zt=%%i" &goto :next
:next
if /i "%zt%"=="RUNNING" (
echo 已经发现该服务在运行，正在停止运行
net stop "Redis"
) else (
echo 该服务现在处于停止状态,将进行启动
net start "Redis"
)
pause