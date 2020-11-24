Steps to Run Application
1. Navigate to GeekTrustTameOfThrones/target
2. Open CMD/GIT Bash/PowerShell in this folder
3. Type command java -jar geektrust.jar "Path of the Query Text file"
	eg:- java -jar geektrust.jar "C:\Sabre_Work\ExtaS\GeekTrustTameOfThrones\src\resources\sample1.txt"
    NOTE:- I have 3 sample files under GeekTrustTameOfThrones\src\resources for testing
4. Hit Enter and your results will be displayed on the screen.

To compile Source code
1. Navigate to GeekTrustTameOfThrones folder 
2. Type mvn clean compile assembly:single
3. Hit Enter
4. Your new jar will be created in target folder

To Run all the test cases
1. Load Project In IDE(Intelij/Eclipse)
2. Execute RulerOfSoutherosProcessorTest