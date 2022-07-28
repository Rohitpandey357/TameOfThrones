This is the solution to the Tame of Thrones problem.

Problem Statement :
Each kingdom has an animal emblem and Shan needs to send a message with the animal in the message to win them over.
SPACE emblem - Gorilla, LAND emblem - Panda, WATER emblem - Octopus,
ICE emblem - Mammoth, AIR emblem - Owl, FIRE emblem - Dragon.
Your coding challenge is to have King Shan send secret message to each kingdom and win them over.
Once he wins 3 more kingdoms, he is the ruler! The secret message needs to contain the letters of the animal in their emblem.
For example, secret message to the Land kingdom (emblem: Panda) needs to have the letter 'p','n','d' at-least once and 'a' atleast
twice. If he sends "ahdvvnxxxautup" to the Land kingdom, he will win them over.
King Shan wants to make sure his secret message is not found by his enemies easily. So he decides to use the oldest of the
ciphers 'Seasar cipher'. A cipher is a type of secret code, where you swap the letters around so that no-one can read your
message.

You can run the solution by following the below steps:

1) Building the solution:
To successfully build the solution run the following command in the main directory :
mvn clean package


2) Testing the solution:
To test the solution, run the following command in the main directory :
mvn test


3) Running the solution:
After successfully building the solution, go into the target directory by using the following command :
cd target

Once you get into the target directory run the following command to run the solution on the input file :
java -jar geektrust.jar <path_to_input_file>
