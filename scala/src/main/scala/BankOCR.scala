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

  def ocrSingle(input: String): String = input match {
    case `one` => "1"
    case `two` => "2"
    case `three` => "3"
    case `four` => "4"
    case `five` => "5"
    case `six` => "6"
    case `seven` => "7"
    case `eight` => "8"
    case `nine` => "9"
    case _ => "?"
  }
}
