package Helper;

import Model.DaOImplements.DaOItem;
import Model.DaOImplements.DaOPurchaseOrder;
import Model.DaOImplements.DaOSupplier;
import Model.DaOImplements.DaoStock;
import Model.DaoObjects.Item;
import Model.DaoObjects.PurchaseOrder;
import Model.DaoObjects.Stock;
import Model.DaoObjects.Supplier;
import Model.StockItemSupplier;

import java.util.ArrayList;
import java.util.List;

public class StockItemSupplierHelper
{
    /**
     * Iterates through the Lists with Database objects to create a combined object
     * @return An ArrayList with combined Database object
     */
    public static ArrayList<StockItemSupplier> getData()
    {
        ArrayList<StockItemSupplier> combinedData = new ArrayList<>();

        List<Stock> stockData = new DaoStock().GetAll();
        List<Supplier> supplierData = new DaOSupplier().GetAll();
        List<Item> itemData = new DaOItem().GetAll();
        List<PurchaseOrder> purchaseOrderData = new DaOPurchaseOrder().GetAll();

        for (Stock stock : stockData)
        {
            Item item = itemData.stream().filter(items -> items.getItemID() == stock.getItemIdProperty())
                    .findFirst()
                    .orElse(null);
            PurchaseOrder purchaseOrder;
            if (item != null)
            {
                purchaseOrder = purchaseOrderData.stream()
                        .filter(order -> order.getItemID() == item.getItemID())
                        .findFirst()
                        .orElse(null);
            }
            else
            {
                purchaseOrder = null;
            }

            Supplier supplierName = null;
            if (purchaseOrder != null)
            {
                supplierName = supplierData.stream().filter(supplier -> supplier.getSupplierID() == purchaseOrder.getSupplierID())
                        .findFirst()
                        .orElse(null);
            }
            if (supplierName != null)
            {
                StockItemSupplier data = new StockItemSupplier(
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
