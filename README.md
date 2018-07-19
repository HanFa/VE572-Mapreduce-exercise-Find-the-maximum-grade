# Mapreduce exercise: Find the maximum grades
First generate ```input/grades.csv``` by

```bash
python3 create_csv.py
```

The input file is something like: 
```bash
cat input/grades.csv | head -10
Shasta Neddo,0896728883,14
Shasta Neddo,0896728883,38
Illa Glander,9991923222,54
Illa Glander,9991923222,44
Leisha Keefauver,7093833514,44
Illa Glander,9991923222,48
Illa Glander,9991923222,77
Genoveva Raysor,6135959255,19
Leisha Keefauver,7093833514,31
Raymond Klaass,8209680345,22

```

Make sure ```tree .``` is

```
tree .
.
├── README.md
├── create_csv.py
├── input
│   └── grades.csv
├── l3-names
│   ├── firstnames.txt
│   └── lastnames.txt
├── mapreduce.iml
└── src
    ├── GradeMapper.java
    ├── GradeReducer.java
    └── MaxGrades.java

3 directories, 9 files
```

Sample grade files contains something like

```
Shasta Neddo,0896728883,14
Shasta Neddo,0896728883,38
Illa Glander,9991923222,54
Illa Glander,9991923222,44
Leisha Keefauver,7093833514,44
Illa Glander,9991923222,48
Illa Glander,9991923222,77
Genoveva Raysor,6135959255,19
...
```

To run the program, first use ```javac``` to compile the java classes and build the artifacts. 

```
tree out
out
├── artifacts
│   └── mapreduce_jar
│       └── mapreduce.jar
└── production
    └── mapreduce
        ├── GradeMapper.class
        ├── GradeReducer.class
        ├── META-INF
        │   └── MANIFEST.MF
        └── MaxGrades.class

5 directories, 5 files

```

After that, run ```hadoop``` using

```$xslt
hadoop jar out/artifacts/mapreduce_jar/mapreduce.jar 
```