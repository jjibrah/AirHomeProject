package com.Abdifatah.airhome

class Home {
    var image:String = ""
    var location:String = ""
    var details:String = ""
    var price:String = ""
    var id:String = ""

    constructor(image: String, location: String, details: String, price: String, id: String) {
        this.image = image
        this.location = location
        this.details = details
        this.price = price
        this.id = id
    }
    constructor()
}