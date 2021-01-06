#get *.jar
mvn clean package
#create container
docker build -t vanadiiii/algorithms:0.1
#run container
docker run vanadiiii/algorithms:0.1
