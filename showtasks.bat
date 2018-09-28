call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openbrowser
echo.
echo Cannot open browser

:openbrowser
start "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" http://localhost:8080/crud/v1/task/getTasks