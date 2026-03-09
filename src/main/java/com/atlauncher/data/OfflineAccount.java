/*
 * ATLauncher - https://github.com/ATLauncher/ATLauncher
 * Copyright (C) 2013-2022 ATLauncher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.atlauncher.data;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class OfflineAccount extends AbstractAccount {
    /**
     * Auto generated serial.
     */
    private static final long serialVersionUID = 7893248293482390L;

    public OfflineAccount(String username) {
        this.username = username;
        this.minecraftUsername = username;
        this.uuid = generateOfflineUUID(username).toString().replace("-", "");
    }

    public static UUID generateOfflineUUID(String username) {
        return UUID.nameUUIDFromBytes(("OfflinePlayer:" + username).getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String getAccessToken() {
        return "0";
    }

    @Override
    public String getSessionToken() {
        return "-";
    }

    @Override
    public String getUserType() {
        return "legacy";
    }

    @Override
    public String getCurrentUsername() {
        return this.minecraftUsername;
    }

    @Override
    public void updateSkinPreCheck() {
    }

    @Override
    public void changeSkinPreCheck() {
    }

    @Override
    public String getSkinUrl() {
        return null;
    }

    public boolean isOffline() {
        return true;
    }

    @Override
    public String toString() {
        return this.minecraftUsername + " (Offline)";
    }
}
