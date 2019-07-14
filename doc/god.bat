@echo off
cd %~dp0
echo [INFO] 确保默认JDK版本为JDK1.7及以上版本,已配置JAVA_HOME.

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m -Dfile.encoding=UTF-8

echo Maven命令为%MVN%
echo ---------------------------------------------------------------------------------
echo *              [Step 1] 编译整个tplan项目                                     *
echo ---------------------------------------------------------------------------------
call %MVN% clean compile -Dmaven.test.skip=true
if errorlevel 1 goto error

echo ---------------------------------------------------------------------------------
echo *              [Step 2] 所有core到本地Maven仓库                                 *
echo ---------------------------------------------------------------------------------
call %MVN% install -Dmaven.test.skip=true

echo ---------------------------------------------------------------------------------
echo *              [Step 3] 打包整个模块工程                                        *
echo ---------------------------------------------------------------------------------
call %MVN% package -Dmaven.test.skip=true
if errorlevel 1 goto error

echo ---------------------------------------------------------------------------------
echo *              [Step 4] 备份整个模块工程,放入对应的build                        *
echo ---------------------------------------------------------------------------------
set "Ymdhi=%date:~,4%%date:~5,2%%date:~8,2%%time:~0,2%%time:~3,2%"
set filename=server_%Ymdhi%
rem echo %filename%
echo 开始创建build目录
md build\%filename%
xcopy singmon-modules\singmon-app\target\app.war build\%filename%\.
xcopy singmon-modules\singmon-simp\target\simp.war build\%filename%\.
xcopy singmon-modules\singmon-web\target\web.war build\%filename%\.
goto end

:error
echo "有错误发生"
:end
pause