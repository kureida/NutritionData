NutritionData
=============
Setup (WINDOWS ONLY):
Preq:
	Google Account
	Github Account
	Apache Maven 3.0.5 (must have M2_HOME set in path)
	Git Bash (or equivalent)	
	Java JDK 1.7.x (must have JAVA_HOME set in path)
	Java IDE (I use IntelliJ and Eclipse Java EE)
		You can download either at http://www.jetbrains.com/idea/download/ or http://www.eclipse.org/downloads/
		For Eclipse, make sure it's the 'Eclipse IDE for Java EE Developers' to be able to modify .jsp files
Downloading Software (if needed):
	1. JDK
		1A. Go to 'www.oracle.com'
		1B. Go to the 'Downloads' tab
		1C. Scroll to the bottom of the screen (or [Ctrl+F] and find 'Download Java for Developers' and click
		1D. Look for 'JDK' and click 'Download'
		1E. Accept License Agreement and go to Windows x86 (for 32-bit machines) or Windows x64 (for 64-bit machines)
			1EA. Most likely the machine will be a 64-bit machine but to make sure go to Start->Computer (right click)->Properties
			1EB. Look under 'System' on the main page and at 'System type:' there is the type of operating system
		1F. Download and follow download instructions
		1G. The download should be under 'C:\Program Files\Java' if defaulted.
			1GA. If not, remeber where you placed it.  For this readme, it will be under 'C:\Program Files\Java'
	2. Maven
		2A. Go to http://maven.apache.org/download.cgi
		2B. Download 'Maven 3.0.5 (Binary zip)', [Ctrl-F] to find faster and click the link that has the .zip extension
		2C. Download and unzip
		2D. Place the unzipped folder into 'C:\Program Files\Apache Software Foundation', either by copy+paste or unzipping
			2DA. If the folder 'Apache Software Foundation' isn't there, create one.  
			2DB. Windows will ask for permissions when installing into 'Program Files', click continue as many times as needed
		2E. For this readme, it will assume that the folder 'apache-maven-3.0.5' will be under 'C:\Program Files\Apache Software Foundation'
	3. Git & Git Bash
		3A. Go to http://git-scm.com/downloads
		3B. Download the latest stable release for windows
		3C. Execute the .exe file downloaded and use default settings
		3D. The following instructions are for creating a SSH key for Github to bypass repetitive type of your username+password
			(highly recommended)
			Instructions are from: https://help.github.com/articles/generating-ssh-keys
			3DA. Open Git Bash
			3DB. Run 'cd ~/.ssh'
			3DC.  -	 'ls', to list files in directory;
				3DCA. If 'id_rsa.pub' or 'id_dsa.pub' exists, skip 3DD and 3DE. 
			3DD.  -  'ssh-keygen -t rsa -C "[your_email@example.com]"
				3DDA. Replace [your_email@example.com] with your email.
			3DE. Press return
			3DF. When prompted for passphrase, press return twice to enable using Github without entering a password
			3DG. Run 'clip < ~/.ssh/id_rsa.pub', to copy SSH key to clipboard
			3DH. Go to Github and Login
			3DI. Click on the Screwdriver & Wrench (Account Settings) in the top right corner of the UI
			3DJ. Click on 'SSH Keys' on the menu to the left of the screen (near the middle)
			3DK. Click on 'Add SSH key'
				3DKA. For 'Title' use any title that holds some significance to the computer you're using
						(If it's a work computer, do 'Work SSH Key')
				3DKB. Click on the 'Key' textbox and paste (Ctrl-V) the SSH key that you copied to the CLIPboard.
				3DKC. Click 'Add key'
			
Setting path for maven & java :
	1. Open the start menu
	2. Right click on 'Computer'
	3. Click 'Properties'
	4. On left side, click 'Advanced system settings'
	5. Click 'Environment Variables' near the bottom of the of the menu (in the Advanced tab)
	6. In 'System variables':
		6A. If JAVA_HOME is not there, click on 'New...'
			6AA. For 'Variable Name' type 'JAVA_HOME'
			6AB. For 'Variable Value' type 'C:\Program Files\Java\[jdk1.7.0_25]'
				6ABA. Inside the [] just choose the version of Java you've downloaded (must be 1.7.x to be stable)
			6AC. Click 'Ok'
		6B. If M2_HOME is not there, click on 'New...'
			6BA. For 'Variable Name' type 'M2_HOME'
			6BB. For 'Variable Value' type 'C:\Program Files\Apache Software Foundation\apache-maven-3.0.5'
			6BC. Click 'Ok'
		6C. Locate 'Path' within the 'System variables' list and double click (or click 'Edit...')
			6CA. Go to the end of 'Path' in 'Variable value'.
			6CB. If the last character is not ';', add ';'
			6CC. Add '%JAVA_HOME%\bin' to the end
				**Important** If a different version of Java has already been added to 'Path' (found by just looking through the path for anything JDK related) make sure '%JAVA_HOME%\bin' comes before it.
			6CD. Add ';'
			6CE. Add '%M2_HOME%\bin' to the end
			6CE. Click 'Ok'
		6D. Click 'Ok' again
		6E. Click 'Ok' to finish
		
To install/import/launch project: 
1. Goto https://github.com/kureida/NutritionData
2. Fork repo
3. Go to your account
4. Get the HTTPS clone URL, put it on clipboard
5. open Git Bash
6. cd into a folder to place project in
7. Call 'git clone [HTTPS clone]'
	7a. Inside [] paste the clone you've copied by clicking the upper left corner of Git Bash->Edit->Paste (ctrl+v does not work)
8. Call 'git checkout dev' to switch to dev branch
**Importing project
9. Go into Java IDE of your choice (Eclipse or IntelliJ)
10. Using Eclipse
	10A. Open up the workspace to where the repo was cloned (when first opening Eclipse or by clicking File->Switch Workspace->Other)
	10B. Installing M2E for Eclipse
		10BA. Go to Help->Eclipse Marketplace
		10BB. Search for 'Maven Integration for Eclipse' and choose the one with (Juno and newer)
		10BC. Install->Confirm
	10C. Import project
		10CA. Click on File then Import
		10CB. Go to the Maven folder->expand folder->Existing Maven Projects
		10CC. At 'Root Directory', click on browse
			10CCA. If your workspace is NOT in the repo (folder that you clone the project in) navigate to repo
			10CCB. Click on NutritionData within the repo 
				10CCBA. Should look like C:\[workspaceLocation]\NutritionData\NutritionData
		10CD. Click 'Finish'
11. Using IntelliJ **experimental, needs refinement
	11A. Click on File->Open...
	11B. In the dialog box, navigate to the repo folder 
		11BA. Should look like C:\[workspaceLocation]\NutritionData\NutritionData
	11C. FIRST-TIME USERS, go to 11CB instead of 11CA
		11CA. For users that have already configured maven for IntelliJ, open project by clicking OK.  Go to 11D.
		11CB. Click Ok
		11CC. Open as Maven project, keep clicking 'Ok' if more dialogs pop up. 
	11D. Go to File->Settings... (Ctrl+Alt+S)
		11DA. Go to 'Maven' on the top half of the list
		11DB. Go to 'Importing'
		11DC. Look for 'Automatically download:'
		11DD. Check both Sources and Documentation
		11DE. Click 'Apply' and then 'Ok'
**Able to program at this point
12. Building & launching the project in Maven using Eclipse & IntelliJ
	12A. Eclipse
		12AA. Go to Run->Run Configurations...
		12AB. Expand 'Maven Build'
		12AC. To launch app:
			12ACA. Run 'DevAppServer' to launch to http://localhost:8080
			12ACB. Run 'UpdateApplication' to launch to http://newtritiondata.appspot.com (MUST HAVE DEVELOPER PERMISSIONS)
	12B. IntelliJ
		12BA. Go to View->Tool Windows (first option)->Maven Projects
		12BB. In the window, [expand the project]->expand 'Plugins'->expand 'appengine'
		12BC. To launch app: 
			12BCA. Click on appengine:devserver to launch to http://localhost:8080
			12BCB. Click on appengine:update to launch to http://newtritiondata.appspot.com (MUST HAVE DEVELOPER PERMISSIONS)