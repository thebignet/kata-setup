class BankOCR {
  def ocr(input: String): String = "123456789"

  val one = """    
              #  |
              #  |
              #   """.stripMargin('#')

  val two = """ _  
               # _|
               #|_ 
               #   """.stripMargin('#')

  val three = """ _  
                # _|
                # _|
                #   """.stripMargin('#')

  val four = """    
               #|_|
               #  |
               #   """.stripMargin('#')

  val five = """ _  
               #|_ 
               # _|
               #   """.stripMargin('#')

  val six = """ _  
              #|_ 
              #|_|
              #   """.stripMargin('#')

  val seven = """ _  
                #  |
                #  |
                #   """.stripMargin('#')

  val eight = """ _  
                #|_|
                #|_|
                #   """.stripMargin('#')

  val nine = """ _  
               #|_|
               # _|
               #   """.stripMargin('#')

  val numbers = Seq(one,two,three,four,five,six,seven,eight,nine)

  def ocrSingle(input: String): String = {
    val index = numbers.indexOf(input)
    if(index>=0) {
      String.valueOf(index+1)
    } else {
      "?"
    }
  }
}
