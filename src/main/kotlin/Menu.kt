import java.util.Scanner

open class MenuItem

class Note (private val name : String, val content : String) : MenuItem() {
    override fun toString(): String {
        return name
    }
}

class Archive(private val name : String)  : MenuItem() {

    val notes = ArrayList<Note>()

    override fun toString(): String {
        return name
    }
}

abstract class Menu<T: MenuItem>(var items: ArrayList<T>, private val firstPhrase : String){
    val scanner = Scanner(System.`in`)

    abstract fun createItem() : T

    private fun render(){
        println("0. $firstPhrase")
        items.forEachIndexed{index, element -> println("${index+1}. $element")}
        println("${items.size+1}. Выход")
        println("Введите номер пункта меню: ")
    }

    fun userInputProcessing(): Int {
        render()
        while(true){
            var input = scanner.nextLine()

            if (!isInteger(input)){
                println("Неверный ввод!\nСледует ввести цифру для выбора пункта меню.\nПопробуйте еще раз..")
                render()
                continue
            } else {
                var number = input.toInt()
                if (number < 0 || number > items.size+1){
                    println("Неверный ввод!\nНет пункта меню с таким номером.\nПопробуйте еще раз..")
                    render()
                    continue
                } else {
                        if (number == 0) items.add(createItem())
                        return number
                }
            }
        }
    }

    private fun isInteger(s: String): Boolean {
        return try {
            s.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}
