@ echo off
%1 %2
ver|find "5.">nul&&goto :Admin
mshta vbscript:createobject("shell.application").shellexecute("%~s0","goto :Admin","","runas",1)(window.close)&goto :eof
:Admin

rem �����ǿ�������

for /f "skip=3 tokens=4" %%i in ('sc query "Redis" ') do set "zt=%%i" &goto :next
:next
if /i "%zt%"=="RUNNING" (
echo �Ѿ����ָ÷��������У�����ֹͣ����
net stop "Redis"
) else (
echo �÷������ڴ���ֹͣ״̬,����������
net start "Redis"
)
pause