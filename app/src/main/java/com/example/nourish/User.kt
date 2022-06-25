package com.example.nourish

class User {
    var pName: String? = null
    var email: String? = null
    var cName: String? = null

    constructor(){}

    constructor(pName: String?, cName: String?, email: String?, ){
        this.pName = pName
        this.email = email
        this.cName = cName
    }
}