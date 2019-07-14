@echo off
cd %~dp0
echo [INFO] ȷ��Ĭ��JDK�汾ΪJDK1.7�����ϰ汾,������JAVA_HOME.

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m -Dfile.encoding=UTF-8

echo Maven����Ϊ%MVN%
echo ---------------------------------------------------------------------------------
echo *              [Step 1] ��������tplan��Ŀ                                     *
echo ---------------------------------------------------------------------------------
call %MVN% clean compile -Dmaven.test.skip=true
if errorlevel 1 goto error

echo ---------------------------------------------------------------------------------
echo *              [Step 2] ����core������Maven�ֿ�                                 *
echo ---------------------------------------------------------------------------------
call %MVN% install -Dmaven.test.skip=true

echo ---------------------------------------------------------------------------------
echo *              [Step 3] �������ģ�鹤��                                        *
echo ---------------------------------------------------------------------------------
call %MVN% package -Dmaven.test.skip=true
if errorlevel 1 goto error

echo ---------------------------------------------------------------------------------
echo *              [Step 4] ��������ģ�鹤��,�����Ӧ��build                        *
echo ---------------------------------------------------------------------------------
set "Ymdhi=%date:~,4%%date:~5,2%%date:~8,2%%time:~0,2%%time:~3,2%"
set filename=server_%Ymdhi%
rem echo %filename%
echo ��ʼ����buildĿ¼
md build\%filename%
xcopy singmon-modules\singmon-app\target\app.war build\%filename%\.
xcopy singmon-modules\singmon-simp\target\simp.war build\%filename%\.
xcopy singmon-modules\singmon-web\target\web.war build\%filename%\.
goto end

:error
echo "�д�����"
:end
pause