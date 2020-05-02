package com.ogyunal.ogulcan.app.security;

import com.ogyunal.ogulcan.backend.data.entity.User;

@FunctionalInterface
public interface CurrentUser {

	User getUser();
}
