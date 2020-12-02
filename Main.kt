/*Project 1 Bitlabs Academy
In-Game Inventory Simulator by Alfi Futuhi
OBJECTIVE:
Membuat program tentang toko senjata seperti di game. Toko ini menjual
dua tipe senjata yaitu senjata General dan senjata Magic. Terdapat fitur-fitur:
1. Menambahkan senjata
2. Melihat Senjata apa saja yang ada
3. Mengupdate Senjata
4. Menghapus Senjata
 */
package com.alfiFutuhi

import java.util.* //Harus pakai ini agar bisa pakai Scanner

//Variabel Global
var scanner = Scanner(System.`in`)

//Collection untuk menampung senjata
var listWeapon= mutableListOf<Weapon>()
var listMagicWeapon= mutableListOf<MagicWeapon>()

open class Weapon{
    //Blueprint Weapon biasa/general
    var damage: Int = 0 //Nilai awal saja
    lateinit var name : String
}

class MagicWeapon: Weapon(){    //Inherit beberapa data
    //Blueprint Weapon Magic = Weapon() + tambahan magic damage
    var magicDamage: Int = 0 //Nilai awal saja
}

fun main() {    //Main Function
    initWeapon()

    //Memanggil menu berulang-ulang selama user tidak memilih angka 5
    do{
        initMenu()
        println()
        print("Choose(input number): ")
        val menu=scanner.nextInt()
        scanner.nextLine()

        when(menu){
            1->createMenu()
            2->menuView()
            3->updateMenu()
            4->deleteMenu()
        }
    }while(menu!=5) //kalau memilih angka lebih basar dari 5, diulang lagi menunya
}

fun initMenu(){
    //Ketika fungsi ini dipanggil, akan muncul di console sebuah menu
    println("Welcome to Dungeon Store Admin Panel")
    println("==================================== \n")
    println("What do you want to do?")
    println("1. Create Item")
    println("2. View Item")
    println("3. Update Item")
    println("4. Delete Item")
    println("5. Exit")
}

fun createMenu(){
    //Menampilan menu data senjata
    do{
        println("1. Weapon")
        println("2. Magic Weapon")
        print("Choose (Input Number): ")
        val choose=scanner.nextInt()
        scanner.nextLine()

        //Selection General atau Magic Weapon
        when(choose) {
            1->{
                val weapon=Weapon()
                print("Weapon's Name: ")
                weapon.name = scanner.nextLine()
                print("Weapon's damage: ")
                weapon.damage = scanner.nextInt()
                scanner.nextLine()
                listWeapon.add(weapon)
                println()
            }
            2->{
                val magicWeapon=MagicWeapon()
                print("Weapon's Name: ")
                magicWeapon.name = scanner.nextLine()
                print("Weapon's Damage: ")
                magicWeapon.damage = scanner.nextInt()
                scanner.nextLine()
                print("Weapon's Magic Damage: ")
                magicWeapon.magicDamage = scanner.nextInt()
                listMagicWeapon.add(magicWeapon)
                println()
            }
            else->{
                println("Please choose ONLY 1 or 2") //warning kalau user memilih selain 1 atau 2
            }
        }
    }while(choose>2)

}

fun menuView(){
    //menu pilihan ditampilkan
    do {
        println("1. Weapon")
        println("2. Magic Weapon")
        print("Choose (Input Number): ")
        val choose = scanner.nextInt()
        scanner.nextLine()

        //Selection General atau Magic
        when(choose){
            1->{
                println("Weapon")
                println("==========")
                listWeapon.forEachIndexed{index, element ->
                    println("${index+1}.        ${element.name}         ${element.damage}")
                }
                println()
            }
            2->{
                println("Magic Weapon")
                println("============")
                listMagicWeapon.forEachIndexed(){index, element ->
                    println("${index+1}.        ${element.name}         ${element.damage}           ${element.magicDamage}")
                }
                println()
            }
            else->{
            println("Please choose ONLY 1 or 2") //warning kalau user memilih selain 1 atau 2
        }
        }
    }while(choose>2)//agar user hanya memasukkan input dibawah 1 atau 2
}

fun initWeapon(){
    //Data awal Senjata general dan magic
    val weapon= Weapon()
    weapon.name= "Long Sword"
    weapon.damage= 70
    listWeapon.add(weapon)

    val magicWeapon= MagicWeapon()
    magicWeapon.name= "Fire Sword"
    magicWeapon.damage= 85
    magicWeapon.magicDamage= 75
    listMagicWeapon.add(magicWeapon)
}

fun updateMenu(){
    //Menu pilihan ditampilkan
    do {
        println("1. Weapon")
        println("2. Magic Weapon")
        print("Choose (Input Number): ")

        val choose = scanner.nextInt()
        scanner.nextLine()

        //Selection Senjata general atau magic
        when(choose){
            1-> {
                println("Weapon")
                println("==========")
                listWeapon.forEachIndexed { index, element ->
                    println("${index + 1}.        ${element.name}         ${element.damage}")

                }
                println()

                //Melakukan Update data
                do{
                    print("Choose Weapon(input number): ")
                    val chooseWeapon = scanner.nextInt()
                    scanner.nextLine()
                    val weapon = listWeapon[chooseWeapon-1] //list dari 1, index dari 0
                    print("New Weapon's name: ")
                    weapon.name = scanner.nextLine()
                    print("New Weapon's damage: ")
                    weapon.damage = scanner.nextInt()
                    scanner.nextLine()
                    println()

                }while(chooseWeapon>listWeapon.size)
            }
            2-> {
                println("Magic Weapon")
                println("============")
                listMagicWeapon.forEachIndexed(){index, element ->
                    println("${index+1}.        ${element.name}         ${element.damage}           ${element.magicDamage}")
                }
                println()

                //Melakukan Update data
                do{
                    print("Choose Magic Weapon: ")
                    val chooseMagicWeapon = scanner.nextInt()
                    scanner.nextLine()
                    val magicWeapon = listMagicWeapon[chooseMagicWeapon-1] //list dari 1, index dari 0
                    print("New Magic Weapon's name: ")
                    magicWeapon.name = scanner.nextLine()
                    print("New Magic Weapon's damage: ")
                    magicWeapon.damage = scanner.nextInt()
                    scanner.nextLine()
                    print("New Magic Weapon's magic damage:")
                    magicWeapon.magicDamage = scanner.nextInt()
                    scanner.nextLine()
                    println()
                }while(chooseMagicWeapon>listMagicWeapon.size)
            }
            else->{
                println("Please choose ONLY 1 or 2") //warning kalau user memilih selain 1 atau 2
            }
        }
    }while(choose>2) //agar user hanya memasukkan input 1 atau 2
}

fun deleteMenu(){
    //Menu pilihan ditampilkan
    do {
        println("1. Weapon")
        println("2. Magic Weapon")
        print("Choose (Input Number): ")

        val choose = scanner.nextInt()
        scanner.nextLine()

        //Selection Senjata General atau magic
        when(choose){
            1-> {
                println("Weapon")
                println("==========")
                listWeapon.forEachIndexed { index, element ->
                    println("${index + 1}.        ${element.name}         ${element.damage}")
                }
                println()

                //Melakukan delete
                println("What do you want to delete?")
                print("Choose (Input Number): ")
                val chooseDelete = scanner.nextInt()
                scanner.nextLine()
                listWeapon.removeAt(chooseDelete-1)
                println()
            }
            2-> {
                println("Magic Weapon")
                println("============")
                listMagicWeapon.forEachIndexed(){index, element ->
                    println("${index+1}.        ${element.name}         ${element.damage}           ${element.magicDamage}")
                }
                println()

                //Melakukan delete
                println("What do you want to delete?")
                print("Choose (Input Number): ")
                val chooseDelete = scanner.nextInt()
                scanner.nextLine()
                listMagicWeapon.removeAt(chooseDelete-1)
                println()
            }
            else->{
                println("Please choose ONLY 1 or 2") //warning kalau user memilih selain 1 atau 2
            }
        }
    }while(choose>2) //agar user hanya memasukkan input 1 atau 2


   /* do{
        val chooseDelete = scanner.nextInt()
        scanner.nextLine()
        when(chooseDelete){
            1->{
                listWeapon.removeAt(chooseDelete-1)
            }
            2->{
                listMagicWeapon.removeAt(chooseDelete-1)
            }
            else{
                println("Please Choose Only 1 or 2")
            }
        }
    }while(chooseDelete<)

    */
}