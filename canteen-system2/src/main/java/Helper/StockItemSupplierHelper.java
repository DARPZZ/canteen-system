package Helper;

import Model.DaOImplements.DaOItem;
import Model.DaOImplements.DaOPurchaseOrder;
import Model.DaOImplements.DaOSupplier;
import Model.DaOImplements.DaoStock;
import Model.DaoObjects.Item;
import Model.DaoObjects.PurchaseOrder;
import Model.DaoObjects.Stock;
import Model.DaoObjects.Supplier;
import Model.StockItemSupplierData;

import java.util.ArrayList;
import java.util.List;

public class StockItemSupplierHelper
{
    public static ArrayList<StockItemSupplierData> getData()
    {
        ArrayList<StockItemSupplierData> combinedData = new ArrayList<>();
        List<Stock> stockData = new DaoStock().GetAll();
        List<Supplier> supplierData = new DaOSupplier().GetAll();
        List<Item> itemData = new DaOItem().GetAll();
        List<PurchaseOrder> purchaseOrderData = new DaOPurchaseOrder().GetAll();


        for (Stock stock : stockData)
        {
            Item item = itemData.stream()
                    .filter(items -> items.getItemID() == stock.getItemIdProperty())
                    .findFirst()
                    .orElse(null);
            PurchaseOrder supplierId;
            if (item != null)
            {
                supplierId = purchaseOrderData.stream()
                        .filter(order -> order.getItemID() == item.getItemID())
                        .findFirst()
                        .orElse(null);
            }
            else
            {
                supplierId = null;
            }
            Supplier supplierName = null;
            if (supplierId != null)
            {
                supplierName = supplierData.stream().filter(supplier -> supplier.getSupplierID() == supplierId.getSupplierID())
                        .findFirst()
                        .orElse(null);
            }
            if (supplierName != null)
            {
                StockItemSupplierData data = new StockItemSupplierData(
                        item.getItemID(),
                        item.getName(),
                        stock.getStockLevelProperty(),
                        stock.getMinStockLevelProperty(),
                        supplierName.getName());
                combinedData.add(data);
            }
        }
        return combinedData;
    }
}
