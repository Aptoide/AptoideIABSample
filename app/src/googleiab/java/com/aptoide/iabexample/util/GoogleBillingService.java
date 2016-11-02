package com.aptoide.iabexample.util;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import java.util.List;

/**
 * Created by marcelobenites on 02/11/16.
 */
class GoogleBillingService implements BillingService {

  private IInAppBillingService service;

  public GoogleBillingService(IBinder service) {
    this.service = IInAppBillingService.Stub.asInterface(service);
  }

  @Override public int isBillingSupported(int apiVersion, String packageName, String type)
      throws RemoteException {
    return service.isBillingSupported(apiVersion, packageName, type);
  }

  @Override
  public Bundle getSkuDetails(int apiVersion, String packageName, String type, Bundle skusBundle)
      throws RemoteException {
    return service.getSkuDetails(apiVersion, packageName, type, skusBundle);
  }

  @Override public Bundle getBuyIntent(int apiVersion, String packageName, String sku, String type,
      String developerPayload) throws RemoteException {
    return service.getBuyIntent(apiVersion, packageName, sku, type, developerPayload);
  }

  @Override public Bundle getPurchases(int apiVersion, String packageName, String type,
      String continuationToken) throws RemoteException {
    return service.getPurchases(apiVersion, packageName, type, continuationToken);
  }

  @Override public int consumePurchase(int apiVersion, String packageName, String purchaseToken)
      throws RemoteException {
    return service.consumePurchase(apiVersion, packageName, purchaseToken);
  }

  @Override public int stub(int apiVersion, String packageName, String type)
      throws RemoteException {
    return service.stub(apiVersion, packageName, type);
  }

  @Override
  public Bundle getBuyIntentToReplaceSkus(int apiVersion, String packageName, List<String> oldSkus,
      String newSku, String type, String developerPayload) throws RemoteException {
    return service.getBuyIntentToReplaceSkus(apiVersion, packageName, oldSkus, newSku, type,
        developerPayload);
  }
}
