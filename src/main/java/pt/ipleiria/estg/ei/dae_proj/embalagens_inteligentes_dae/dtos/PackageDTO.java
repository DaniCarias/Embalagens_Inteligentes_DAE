package pt.ipleiria.estg.ei.dae_proj.embalagens_inteligentes_dae.dtos;

import pt.ipleiria.estg.ei.dae_proj.embalagens_inteligentes_dae.entities.Package;

import java.util.Date;

public class PackageDTO {

    private long id;
    private Package.PackageType packageType;
    private Date lastTimeOpened;
    private String material;
    private long product_id;
    private long order_id;
    private String username_manufacturer;


    public PackageDTO() {
    }

    public PackageDTO(long id, Package.PackageType packageType, Date lastTimeOpened, String material, long product_id, long order_id, String username_manufacturer) {
        this.id = id;
        this.packageType = packageType;
        this.lastTimeOpened = lastTimeOpened;
        this.material = material;
        this.product_id = product_id;
        this.order_id = order_id;
        this.username_manufacturer = username_manufacturer;
    }

    public PackageDTO(long id, Package.PackageType packageType, Date lastTimeOpened, String material, String username_manufacturer) {
        this.id = id;
        this.packageType = packageType;
        this.lastTimeOpened = lastTimeOpened;
        this.material = material;
        this.username_manufacturer = username_manufacturer;
    }

    public PackageDTO(long id, Package.PackageType packageType, Date lastTimeOpened, String material, long product_id, String username_manufacturer) {
        this.id = id;
        this.packageType = packageType;
        this.lastTimeOpened = lastTimeOpened;
        this.material = material;
        this.product_id = product_id;
        this.username_manufacturer = username_manufacturer;
    }





    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Package.PackageType getPackageType() {
        return packageType;
    }
    public void setPackageType(Package.PackageType packageType) {
        this.packageType = packageType;
    }
    public Date getLastTimeOpened() {
        return lastTimeOpened;
    }
    public void setLastTimeOpened(Date lastTimeOpened) {
        this.lastTimeOpened = lastTimeOpened;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public long getProduct_id() {
        return product_id;
    }
    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }
    public long getOrder_id() {
        return order_id;
    }
    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }
    public String getUsername_manufacturer() {
        return username_manufacturer;
    }
    public void setUsername_manufacturer(String username_manufacturer) {
        this.username_manufacturer = username_manufacturer;
    }
}
