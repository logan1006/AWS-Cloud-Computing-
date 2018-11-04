
//build spark conf
val conf = new SparkConf().setAppName("Tera Sort")

//build spark context
val context = new SparkContext(conf)

//read from input file
val lines = context.textFile("hdfs://localhost:9000/input")

//split the file based on fist 10 characters and map to rdd
val rdd = lines.map(x => (x.slice(0,10),x.slice(10,99)))

//sort the rdd using key
val sortedrdd = rdd.sortByKey()

//save the sorted rdd to text file
sortedrdd.map(k => k._1+ "\t" +k._2).saveAsTextFile("hdfs://localhost:9000/output")

//exit shell
System.exit(0)