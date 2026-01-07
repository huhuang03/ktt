set windows-shell := ["powershell.exe", "-NoLogo", "-Command"]

lexer:
    ./gradlew :compiler:psi:parser:lexer --no-configuration-cache --no-parallel --max-workers=1

lexer-verbose:
    ./gradlew :compiler:psi:parser:lexer --no-configuration-cache --no-parallel --max-workers=1 --debug