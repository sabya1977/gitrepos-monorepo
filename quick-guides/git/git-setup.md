-- setup initial git
git config --global user.name "Sabyasachi Mitra"
git config --global user.email "sabyasachihyd2003@gmail.com"
git config --global core.editor nvim

-- show git config
git config --list --show-origin

--Check if SSH key already exists
ls ~/.ssh
--If you see id_rsa and id_rsa.pub, you already have one.
--
--Generate RSA SSH key
ssh-keygen -t rsa -b 4096 -C "sabyasachihyd2003@gmail.com"

This creates:
~/.ssh/id_rsa → private key (DO NOT SHARE)
~/.ssh/id_rsa.pub → public key (upload to GitHub)

--Start SSH agent and add key
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_rsa

--Add SSH key to GitHub
cat ~/.ssh/id_rsa.pub

--Test SSH connection
ssh -T git@github.com
press yes to add the host

-- Initiating an Existing GitHub Repository on Linux
git clone git@github.com:username/repository.git

--Existing local folder → link to GitHub repo
git init
git branch -M main
git remote add origin git@github.com:username/repository.git
git add .
git commit -m "Initial commit"
git push -u origin main

--Verify remote
git remote -v

--Add SSH remote
git remote add origin git@github.com:username/repository.git

--Check your current remote
git remote -v

--One-liner alternative (instead of remove + add)
git remote set-url origin git@github.com:username/repository.git

--Remove existing remote
git remote remove origin
