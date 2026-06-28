To start a wsl distribution
wsl --distribution FedoraLinux-42
--
--  Terminates the specified distribution
 wsl --terminate, -t FedoraLinux-42

wsl --help 
--
-- to get list of all supported WSL linux distributions
--
wsl --list (-l) --online (-o) 
--
-- to get list of all running linux distributions in WSL
--
wsl --list (-l) --running (-r) 
--
-- to get list of all linux distributions in WSL
wsl --all (-a)
--
-- to uninstall a linux distribution
wsl --unregister (-u) <distribution name>
--
-- install a distribution
wsl --install (-i) <distribution name>
--
--  Sets the distribution as the default.
wsl set-default, -s <Distro>
--
 --user, -u <UserName>
        Run as the specified user.