import React from 'react';
import { Outlet } from 'react-router-dom';

const MainLayout = () => {
  return (
    <div>
      <header>
        {/* Add any navbar/header here */}
        <h1>Welcome to the Hospital Management Website</h1>
      </header>
      <main>
        <Outlet />
      </main>
    </div>
  );
};

export default MainLayout;
