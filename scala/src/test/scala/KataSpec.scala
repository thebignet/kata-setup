import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {

  "Bank OCR" should "read 123456789" in {
    val kata = new BankOCR
    val input ="""    _  _     _  _  _  _  _ 
                 #  | _| _||_||_ |_   ||_||_|
                 #  ||_  _|  | _||_|  ||_| _|
                 #                            """.stripMargin('#')
    val result = kata.ocr(input)
    result should be("123456789")
  }

  it should "read a 1 digit" in {
    val kata = new BankOCR
    val input ="""    
                 #  |
                 #  |
                 #   """.stripMargin('#')
    val result = kata.ocrSingle(input)
    result should be("1")
  }

}