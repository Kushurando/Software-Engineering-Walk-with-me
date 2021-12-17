// Generated by view binder compiler. Do not edit!
package com.walkwithme.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.walkwithme.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSettingsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button DeleteProfileButton;

  @NonNull
  public final Button ManagePicturesButton;

  @NonNull
  public final Button ManageProfileButton;

  @NonNull
  public final Button PreferencesButton;

  private FragmentSettingsBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button DeleteProfileButton, @NonNull Button ManagePicturesButton,
      @NonNull Button ManageProfileButton, @NonNull Button PreferencesButton) {
    this.rootView = rootView;
    this.DeleteProfileButton = DeleteProfileButton;
    this.ManagePicturesButton = ManagePicturesButton;
    this.ManageProfileButton = ManageProfileButton;
    this.PreferencesButton = PreferencesButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSettingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_settings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSettingsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.DeleteProfileButton;
      Button DeleteProfileButton = ViewBindings.findChildViewById(rootView, id);
      if (DeleteProfileButton == null) {
        break missingId;
      }

      id = R.id.ManagePicturesButton;
      Button ManagePicturesButton = ViewBindings.findChildViewById(rootView, id);
      if (ManagePicturesButton == null) {
        break missingId;
      }

      id = R.id.ManageProfileButton;
      Button ManageProfileButton = ViewBindings.findChildViewById(rootView, id);
      if (ManageProfileButton == null) {
        break missingId;
      }

      id = R.id.PreferencesButton;
      Button PreferencesButton = ViewBindings.findChildViewById(rootView, id);
      if (PreferencesButton == null) {
        break missingId;
      }

      return new FragmentSettingsBinding((ConstraintLayout) rootView, DeleteProfileButton,
          ManagePicturesButton, ManageProfileButton, PreferencesButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
