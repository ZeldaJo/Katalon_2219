import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// ============================= OPEN BROWSER =============================
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.evershop)

// ============================= LOGIN =============================
WebUI.click(findTestObject('Page_An Amazing EverShop Store/path'))

WebUI.verifyElementPresent(findTestObject('Page_Login/div_LoginSIGN INCreate an accountForgot you_ef2082'), 3)

WebUI.setText(findTestObject('Page_Login/input_Login_email'), username)

WebUI.setText(findTestObject('Page_Login/input_Login_password'), password)

WebUI.click(findTestObject('Page_Login/button_SIGN IN'))

// ============================= HOME PAGE =============================
WebUI.verifyElementPresent(findTestObject('Page_An Amazing EverShop Store/div_Your Heading Here      Lorem ipsum dolo_47a676'), 
    3)

WebUI.click(findTestObject('Page_An Amazing EverShop Store/a_Shop women'))

// ============================= WOMEN PAGE =============================
WebUI.verifyElementPresent(findTestObject('Page_Women/div_Women'), 3)

WebUI.scrollToElement(findTestObject('Page_Women/Pilih Produk Sepatu', [('product') : product]), 3)

WebUI.click(findTestObject('Page_Women/Pilih Produk Sepatu', [('product') : product]))

// ============================= PRODUCT PAGE =============================
WebUI.verifyElementPresent(findTestObject('Page_Nike Drop-Type Premium/main_Home  Women  Nike Drop-Type PremiumNik_2b8fd3'), 
    3)

WebUI.scrollToElement(findTestObject('Page_Nike Odyssey React Flyknit 2/Ukuran', [('ukuran') : ukuran]), 3)

WebUI.click(findTestObject('Page_Nike Odyssey React Flyknit 2/Ukuran', [('ukuran') : ukuran]))

WebUI.scrollToElement(findTestObject('Page_Nike Odyssey React Flyknit 2/Warna', [('warna') : warna]), 3)

WebUI.click(findTestObject('Page_Nike Odyssey React Flyknit 2/Warna', [('warna') : warna]))

WebUI.scrollToElement(findTestObject('Page_Nike Drop-Type Premium/Jumlah Item'), 3)

WebUI.setText(findTestObject('Page_Nike Drop-Type Premium/Jumlah Item'), jumlah)

// ============================= ADD TO CART =============================
WebUI.scrollToElement(findTestObject('Page_Nike Drop-Type Premium/button_ADD TO CART'), 3)

WebUI.click(findTestObject('Page_Nike Drop-Type Premium/button_ADD TO CART'))

WebUI.waitForElementVisible(findTestObject('Page_Nike Odyssey React Flyknit 2/Notif Keranjang'), 3)

WebUI.verifyElementPresent(findTestObject('Page_Nike Odyssey React Flyknit 2/Notif Keranjang'), 3)

// ============================= VIEW CART =============================
WebUI.click(findTestObject('Page_Nike Drop-Type Premium/a_VIEW CART (1)'))

WebUI.verifyElementPresent(findTestObject('Page_Shopping cart/div_ProductPriceQuantityTotalNike drop-type_120194'), 3)

// ============================= CHECKOUT PAGE =============================
WebUI.click(findTestObject('Page_Shopping cart/a_CHECKOUT'))

WebUI.verifyElementPresent(findTestObject('Page_Checkout/div_Contact information Shipment Payment Co_4cbb46'), 3)

// ============================= ISI FORM CHECKOUT =============================
WebUI.setText(findTestObject('Page_Checkout/input_Full name_addressfull_name'), nama)

WebUI.setText(findTestObject('Page_Checkout/input_Telephone_addresstelephone'), telepon)

WebUI.delay(1)

// CASE 1: Dua-duanya kosong
if (((nama == null) || (nama.trim() == '')) && ((telepon == null) || (telepon.trim() == ''))) {
    WebUI.waitForElementVisible(findTestObject('Page_Checkout/Nama Kosong'), 5)

    WebUI.waitForElementVisible(findTestObject('Page_Checkout/No Telepon Kosong'), 5)

    println('❗ ERROR: Nama & Telepon tidak boleh kosong.')

    WebUI.closeBrowser()

    KeywordUtil.markTestSkipped('SKIPPED: Nama & Telepon kosong')

    return null
    // CASE 2: Nama kosong
    // CASE 3: Telepon kosong
} else if ((nama == null) || (nama.trim() == '')) {
    WebUI.waitForElementVisible(findTestObject('Page_Checkout/Nama Kosong'), 5)

    println('❗ ERROR: Nama tidak boleh kosong.')

    WebUI.closeBrowser()

    KeywordUtil.markTestSkipped('SKIPPED: Nama kosong')

    return null
} else if ((telepon == null) || (telepon.trim() == '')) {
    WebUI.waitForElementVisible(findTestObject('Page_Checkout/No Telepon Kosong'), 5)

    println('❗ ERROR: No Telepon tidak boleh kosong.')

    WebUI.closeBrowser()

    KeywordUtil.markTestSkipped('SKIPPED: Telepon kosong')

    return null
}

WebUI.comment('✔ Nama & Telepon valid — lanjut proses checkout.')

// ============================= LANJUT ISI FORM =============================
WebUI.setText(findTestObject('Page_Checkout/input_Address_addressaddress_1'), alamat)

WebUI.setText(findTestObject('Page_Checkout/input_City_addresscity'), city)

WebUI.selectOptionByValue(findTestObject('Page_Checkout/Pilih Negara'), kota, true)

WebUI.selectOptionByValue(findTestObject('Page_Checkout/Pilih Provinsi'), provinsi, true)

WebUI.setText(findTestObject('Page_Checkout/input_Postcode_addresspostcode'), '12345')

// ============================= COMMENT =============================
WebUI.waitForElementVisible(findTestObject('Page_Checkout/isi comment'), 3)

WebUI.waitForElementClickable(findTestObject('Page_Checkout/isi comment'), 3)

WebUI.setText(findTestObject('Page_Checkout/isi comment'), comment)

WebUI.click(findTestObject('Page_Checkout/button_Save'))

WebUI.verifyElementPresent(findTestObject('Page_Checkout/Notif Deskripsi Tersimpan'), 3)

// ============================= SHIPPING =============================
WebUI.click(findTestObject('Page_Checkout/div_Express Delivery - 15.00Standard Delive_980d45'))

WebUI.click(findTestObject('Page_Checkout/span_Shipping Method_radio-unchecked'))

WebUI.click(findTestObject('Page_Checkout/button_Continue to payment'))

// ============================= PAYMENT =============================
WebUI.click(findTestObject('Page_Checkout/svg'))

WebUI.verifyElementPresent(findTestObject('Page_Checkout/div_Contact information Shipment Payment Co_c85258'), 3)

WebUI.click(findTestObject('Page_Checkout/div_Payment Method_divide-y border rounded _8a9d0e'))

WebUI.click(findTestObject('Page_Checkout/svg_1'))

WebUI.click(findTestObject('Page_Checkout/button_Place Order'))

// ============================= SUCCESS PAGE =============================
WebUI.verifyElementPresent(findTestObject('Page_Checkout success/h3_Order 22528Thank you Budi Asep'), 3)

WebUI.click(findTestObject('Page_Checkout success/a_CONTINUE SHOPPING'))

WebUI.verifyElementPresent(findTestObject('Page_An Amazing EverShop Store/div_Your Heading Here      Lorem ipsum dolo_47a676'), 
    3)

WebUI.closeBrowser()

