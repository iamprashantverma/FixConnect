import { useCallback, useEffect, useState } from "react";
import AuthContext from "./authContext";

const AuthProvider = ({ children }) => {
  
  const [user, setUser] = useState(null);
  const [initializing, setInitializing] = useState(true);
  const [loading, setLoading] = useState(false);

  useEffect(() => {

    const initAuth = async () => {
      await new Promise((r) => setTimeout(r, 300));
      setUser(null);
      setInitializing(false);
    };

    initAuth();
  }, []);

  const login = useCallback(async (userData) => {
    setLoading(true);
    setUser(userData); 
    setLoading(false);
  }, []);


  const logout = useCallback(async () => {
    setLoading(true);
    setUser(null);
    setLoading(false);
  }, []);

  if (initializing) return null;

  return (
    <AuthContext.Provider value={{
        user,
        loading,
        login,
        logout,
    }}>
      {children}
    </AuthContext.Provider>
  );
};
export default AuthProvider;
